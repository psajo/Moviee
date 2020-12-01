package com.utte.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utte.beans.Member;
import com.utte.dao.MemberDAO;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MypageServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Session에 담긴 정보 가져오기*/
		HttpSession session = request.getSession();
		Member mvo = (Member)session.getAttribute("mvo");
		String m_email = mvo.getM_email();
		
		/*MyPage.jsp에 입력된 정보 가져오기*/
		String currPwd = request.getParameter("currPwd");
		String newPwd = request.getParameter("newPwd");
		String checkPwd = request.getParameter("checkPwd");
		
		Member temp = MemberDAO.select(m_email, currPwd);
		
		System.out.println("A 비밀번호:"+currPwd);
		System.out.println("B 비밀번호:"+newPwd);
		System.out.println("C 비밀번호:"+checkPwd);
		System.out.println("DB 비밀번호:"+temp.getM_pwd());
		System.out.println("아이디:"+m_email);
		
		
		//1. 기존비밀번호 새 비밀번호 비교
		response.setContentType("text/html;charset=utf-8");
		PrintWriter script = response.getWriter();
		script.println("<script>");
		
		if(currPwd.equals(temp.getM_pwd())) {
			System.out.println("입력한 기존 비밀번호와 DB에 저장된 비밀번호가 같습니다.");
			//일치했다 -->업데이트
			if(newPwd.equals(checkPwd)) {
				script.println("alert('비밀번호 변경 완료');");

				int result = MemberDAO.Update_password(newPwd,m_email);
				response.sendRedirect(request.getContextPath()+"/mypage.jsp"); 
			}else {
				script.println("alert('비밀번호 변경 실패');");
				response.sendRedirect(request.getContextPath()+"/mypage.jsp"); 
			}
		}else {
			//불일치
			script.println("alert('비밀번호가 맞지 않습니다.');");
			response.sendRedirect(request.getContextPath()+"/mypage.jsp"); 
		}
		script.println("</script>");
		
	}

}
