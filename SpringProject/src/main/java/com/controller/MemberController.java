package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;


import com.dto.MemberDTO;
import com.dto.NaverDTO;
import com.dto.QnaDTO;
import com.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService ser;
	
	private static final String mydomain = "http://localhost:8090/cat/callback";
	private static final String clientId = "Y5w0sYA5mSg7O0ykx5AE";
	private static final String clientSecret = "Iu0GeegmeC";
	private static final String requestUrl = "https://nid.naver.com/oauth2.0/authorize?client_id=" + 
	clientId + "&response_type=code&redirect_uri="+ mydomain + "&state="; 
	 private String getAccessUrl(String state, String code) {
		  String accessUrl = "https://nid.naver.com/oauth2.0/token?client_id=" + clientId + "&client_secret=" + clientSecret
		    + "&grant_type=authorization_code" + "&state=" + state + "&code=" + code;
		  return accessUrl;
		 }
	

	 
	 @RequestMapping("/m/sendQna")
	 public ModelAndView sendQna(QnaDTO dto) {
		 System.out.println(dto);
		 ModelAndView mav = new ModelAndView();
		 String mesg = null;
		    String email = dto.getEmail();
			String host = "smtp.naver.com";
			String subject = "문의사항입니다.";
			String from = email; //보내는 메일
			String fromName = dto.getName()+email;
			String to = "wndgus4444@naver.com"; //받는 메일
			String content = dto.getContent();
			
			try{
				//프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
				Properties props = new Properties();
				//네이버 SMTP 사용시
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.transport.protocol","smtp");
				props.put("mail.smtp.host", host);
				
				props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
				props.put("mail.smtp.user", from);
				props.put("mail.smtp.auth","true");
				props.put("mail.smtp.debug", "true");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "false");
				
				
				Authenticator auth = new SendMail();
				Session mailSession = Session.getDefaultInstance(props,auth);
				Message msg = new MimeMessage(mailSession);
				msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
				InternetAddress[] address = {new InternetAddress(to)};
				msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
				msg.setSubject(subject); //제목설정
				System.out.println("3차");
				msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
				msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
				System.out.println("4차");
				Transport.send(msg); //메일 보내기
				mesg = "메일이 성공적으로 발송되었으며 24시간이내에 답신이 도착하지 않는다면 메일주소를 확인해주세요";
			}catch(MessagingException ex){
				System.out.println("mail send error : "+ex.getMessage());
				mesg = "잘못된 이메일 형식입니다.";
				ex.printStackTrace();
			}catch(Exception e){
				System.out.println("error : "+e.getMessage());
				e.printStackTrace();
			}
			mav.setViewName("qna");
			mav.addObject("mailmesg", mesg);
			return mav;
	 }
	 
	 
	 
	 @RequestMapping("/m/qna")
	 public String qna() {
		 return "qna";
	 }

	@RequestMapping(value = "/naverLogin")
	 public String naverLogin(HttpSession session) {
	  String state = Utils.generateState();     //토큰을 생성합니다.
	  session.setAttribute("state", state);      //세션에 토큰을 저장합니다.
	  return "redirect:" + requestUrl + state;   //만들어진 URL로 인증을 요청합니다.
	 }
	 @RequestMapping("/callback")
	 public String callback(@RequestParam String state, @RequestParam String code, 
			 HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
	  String storedState = (String) request.getSession().getAttribute("state");  //세션에 저장된 토큰을 받아옵니다.
	  String data = Utils.getHtml(getAccessUrl(state, code), null);           //AccessToken을 요청하고 그 값을 가져옵니다.
		 Map<String,String> map = Utils.JSONStringToMap(data);               //JSON의 형태로 받아온 값을 Map으로 저장합니다.
		 String accessToken = map.get("access_token");
		 String tokenType = map.get("token_type"); 
		 String profileDataXml = Utils.getHtml(userProfileUrl, tokenType +" "+ accessToken); 
		// tokentype 와 accessToken을 조합한 값을 해더의 Authorization에 넣어 전송합니다. 결과 값은 xml로 출력됩니다. 
		JSONObject jsonObject =  XML.toJSONObject(profileDataXml);     //xml을 json으로 파싱합니다.
		JSONObject responseData = jsonObject.getJSONObject("data");   
		//json의 구조가 data 아래에 자식이 둘인 형태여서 map으로 파싱이 안됩니다. 따라서 자식 노드로 접근합니다.
		Map<String,String> userMap = Utils.JSONStringToMap(responseData.get("response").toString());
		 
		String username = userMap.get("name");
		String email = userMap.get("email");
		System.out.println(email);
		NaverDTO naverCheck = ser.naverCheck(email);
		System.out.println(naverCheck);
		int n2 =1;
		if(naverCheck == null) {
			 Map<String, Object> map2 = new HashMap<String, Object>();
			 map2.put("username", userMap.get("name")); 
			 map2.put("email", userMap.get("email"));
			 int n = ser.naverInsert(map2);
			 NaverDTO naver = ser.naverCheck(email);
			 session.setAttribute("nlogindto", naver);
		}else {
			session.setAttribute("nlogindto", naverCheck);
		}
		
		
		 
		//사용자 정보 값은 자식노드 중에 response에 저장되어 있습니다. response로 접근하여 그 값들은 map으로 파싱합니다.

	  if (!state.equals(storedState)) {             //세션에 저장된 토큰과 인증을 요청해서 받은 토큰이 일치하는지 검증합니다.
	   System.out.println("401 unauthorized");   //인증이 실패했을 때의 처리 부분입니다.
	   return "redirect:/main";
	  }
	         //AccessToken 요청 및 파싱할 부분
	  return "redirect:/main";
	 }
	 
	 private static final String userProfileUrl = "https://apis.naver.com/nidlogin/nid/getUserProfile.xml";


	
	@RequestMapping("loginForm")
	public String login(@RequestParam Map<String, Object> map,
			HttpSession session) {
		MemberDTO dto = ser.idCheck(map);
		String nextPage = "";
		if(dto!=null) {
			session.setAttribute("logindto", dto);
			nextPage = "main";
		}else {
			String mesg = "회원정보가 틀렸습니다.";
			System.out.println(mesg);
			session.setAttribute("loginmesg", mesg);
			nextPage = "login";
		}
		return nextPage;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	@RequestMapping("memberAdd")
	public String memberAdd(MemberDTO dto, HttpSession session) {
		int n = ser.memberSignup(dto);
		if(n!=0) {
			session.setAttribute("memberAdd", "회원가입성공");
		}
		session.setMaxInactiveInterval(5);
		return "redirect:/main";
	}
	
	@RequestMapping("signupIdCheck")
	public @ResponseBody String signupIdCheck(@RequestParam String userid) {
		int n = ser.signUpCheck(userid);
		String mesg = "";
		if(n==0) {
			mesg="o";
		}else {
			mesg="x";
		}
		return mesg;
	}
	
	@RequestMapping("/m/mypage")
	public String mypage() {
		return "mypage";
	}
	
	@RequestMapping("/m/memberUpdate")
	public ModelAndView memberUpdate(MemberDTO dto, HttpSession session,
			@RequestParam String email) {
		String [] e = email.split("@");
		String email1= e[0];
		String email2 = e[1];
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		int n = ser.memberUpdate(dto);
		MemberDTO ldto = ser.idSerch(dto.getUserid());
		ModelAndView mav = new ModelAndView();
		if(n ==1) {
			String mesg = "정보가 수정되었습니다.";
			session.setAttribute("logindto", ldto);
			mav.setViewName("mypage");
			mav.addObject("upmesg", mesg);
		}
		return mav;
	}
	
	@RequestMapping("/m/memberDelForm")
	public String memberDelForm() {
		return "memberDelForm";
	}
	
	@RequestMapping("/m/memberDel")
	public ModelAndView memberDel(@RequestParam String password,
			HttpSession session) {
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		ModelAndView mav = new ModelAndView();
		String mesg="";
		if(dto.getPassword().equals(password)) {
			int n = ser.memberDel(dto.getUserid());
			mesg = "회원탈퇴가 무사회 완료되었습니다.";
			session.removeAttribute("logindto");
			mav.setViewName("redirect:/main");
			mav.addObject("delmesg", mesg);
		}else {
			mesg="비밀번호를 확인해주세요";
			mav.setViewName("memberDelForm");
			mav.addObject("delmesg", mesg);
		}
		return mav;
	}
	
}
