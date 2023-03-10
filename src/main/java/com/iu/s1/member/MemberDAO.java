package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.product.ProductDTO;
import com.iu.s1.util.DBConnection;
import com.iu.s1.util.Pager;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.iu.s1.member.MemberDAO.";
	
	public List<MemberDTO> getMemberList() throws Exception {
		return sqlSession.selectList(namespace + "getMemberList");
	}
	public int getMemberID() throws Exception {
		return sqlSession.selectOne(namespace + "getMemberID");
	}
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(namespace + "memberJoin", memberDTO);
	}
	public int setMemberRoleAdd(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(namespace + "setMemberRoleAdd",memberDTO);
	}
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(namespace + "getMemberLogin", memberDTO);
	}
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(namespace + "setMemberUpdate", memberDTO);
	}
	public MemberDTO getMemberDetail(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(namespace +"getMemberDetail", memberDTO);
	}
}
