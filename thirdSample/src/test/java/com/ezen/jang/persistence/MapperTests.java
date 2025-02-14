package com.ezen.jang.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.jang.dto.MemberVO;
import com.ezen.jang.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {

	@Autowired
	private MemberMapper memberMapper;

	@Test
	public void testGetTime() {
		log.info(memberMapper.getClass().getName());
		log.info(memberMapper.getTime());
	}
	
	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(6)
				.name("장노아")
				.phone("010-1234-5678")
				.address("경기도 화성시")
				.build();
		
		memberMapper.insertMember(vo);
	}
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(6)
				.name("장에스더")
				.phone("010-7864-3241")
				.address("경기도 화성시")
				.build();
		
		memberMapper.updateMember(vo);
	}
	
	@Test
	public void testDelete() {
		memberMapper.deleteMember(18);
	}
	
	
	@Test
	public void testSelectOne() {
		MemberVO vo = memberMapper.selectOneMember(6);
		log.info(vo);
		
	}
	
	@Test
	public void testAllList() {
		memberMapper.selectAllList()
		.forEach(vo-> log.info(vo));
	}
	
	
}
