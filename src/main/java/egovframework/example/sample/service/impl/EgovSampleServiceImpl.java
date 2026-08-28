/*
 * Copyright (c) 2009-2026 MOIS (MINISTRY OF THE INTERIOR AND SAFETY).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16                최초생성
 * @ 2026.06.19                [2026년 컨트리뷰션] 문자열 기반 설정 제거
 * @ 2026.06.25                [2026년 컨트리뷰션] 생성자 주입으로 변경
 * @ 2026.07.04  정찬영          [2026년 컨트리뷰션] 미사용 import 제거 및 @Slf4j로 로거 선언 통일
 *   2026.07.16  이백행          [2026년 컨트리뷰션] 불필요한 예외 제거
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 */
@Service("sampleService")
@RequiredArgsConstructor
@Slf4j
public class EgovSampleServiceImpl extends EgovAbstractServiceImpl implements EgovSampleService {

	private final SampleMapper sampleMapper;

	private final EgovIdGnrService egovIdGnrService;

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		log.debug(vo.toString());

		sampleMapper.insertSample(vo);
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 */
	@Override
	public void updateSample(SampleVO vo) {
		sampleMapper.updateSample(vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 */
	@Override
	public void deleteSample(SampleVO vo) {
		sampleMapper.deleteSample(vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		SampleVO resultVO = sampleMapper.selectSample(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 글 목록을 조회한다.
	 * @param vo - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 */
	@Override
	public List<?> selectSampleList(SampleVO vo) {
		return sampleMapper.selectSampleList(vo);
	}

	/**
	 * 글 총 개수를 조회한다.
	 * @param vo - 조회할 정보가 담긴 VO
	 * @return 글 총 개수
	 * @exception
	 */
	@Override
	public int selectSampleListTotCnt(SampleVO vo) {
		return sampleMapper.selectSampleListTotCnt(vo);
	}

}
