package kr.com.ezen.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testGetTime() {
		
		log.info("-------------------------------");
		log.info(memberMapper.getClass().getName());
		log.info(memberMapper.getTime());
		log.info("-------------------------------");
		
	}
	
	@Test
	public void testInsert() {
		//MemberVO vo = new MemberVO();
		//vo.setId(10);
		//vo.setName("유비");
		//vo.setPhone("010-1234-1234");
		//vo.setAddress("서울시...");
		//memberMapper.insertMember(vo);
		
		for(int i=0; i<10; i++) {
		MemberVO vo = MemberVO.builder()
				.id(10+i)
				.name("user"+i)
				.phone("010-1234-1234"+i)
				.address("서울시 장안구"+i)
				.build();
		
		memberMapper.insertMember(vo);
		}
	}
	
	
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder()
				.id(19)
				.name("조운")
				.phone("010-1234-1234")
				.address("경기도 수원시")
				.build();
		
		memberMapper.updateMember(vo);
	}
	
	@Test
	public void testDelete() {
		memberMapper.deleteMember(19);
	}
	
	
	@Test
	public void testSelectOne() {
		MemberVO vo = memberMapper.selectOneMember(18);
		log.info(">>>>>>>"+vo);
	}
	
	@Test
	public void testAllList() {
//		List<MemberVO> list = memberMapper.selectAllList();
//		for(MemberVO vo : list)
//			log.info(vo);
		memberMapper.selectAllList()
		.forEach(vo -> log.info(vo));
	
	}
	
	
	
}
