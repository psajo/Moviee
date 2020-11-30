package com.utte.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.utte.beans.Member;
import com.utte.dao.MemberDAO;

/**
 * Servlet implementation class UploadProfile
 */
@WebServlet("/UploadProfile")
public class UploadProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member mvo = (Member)session.getAttribute("mvo");
		String path = "resources\\upload\\";
		//서버에 저장될 경로
		String fullpath=request.getSession().getServletContext().getRealPath(path+mvo.getM_nick());
		System.out.println(fullpath+"\\"+mvo.getM_profile());
		File folder = new File(fullpath);
		//닉네임으로 폴더 생성
		if(!folder.exists()) {
			System.out.println("폴더생성");
			folder.mkdir();
		}else {
			System.out.println("폴더가 이미 존재함");
		}
		//파일이 존재하는 경우 삭제
		if(mvo.getM_profile() != null) {
			System.out.println("프로필있는경우");
			File f = new File(fullpath+"\\"+mvo.getM_profile());
			System.out.println("프로필이름 : "+f.getName());
			if(f.exists()) {
				System.out.println("중복파일 삭제");
				f.delete();
			}
		}
		int size= 1024*1024*10;//저장가능한 파일 최대 크기
		MultipartRequest multi = new MultipartRequest(request,fullpath, size, "UTF-8",new DefaultFileRenamePolicy() );
		File file =multi.getFile("profile");
		MemberDAO.UpdateProfile(mvo.getM_email(), file.getName());
		mvo.setM_profile(file.getName());
		session.setAttribute("mvo", mvo);
		System.out.println(file.getName());
		
	}

}
