package com.ncs.capstone.student.util;

import com.ncs.capstone.student.dto.TestScoreResponseDTO;
import com.ncs.capstone.student.model.TestScore;

public class TestScoreConversionDTO {

	public static TestScoreResponseDTO convertToResponse(TestScore ts) {
		TestScoreResponseDTO dto = new TestScoreResponseDTO();

		dto.setTestId(ts.getTestId());
		dto.setDate(ts.getDate());
		dto.setCategory(ts.getCategory());
		dto.setLevel(ts.getLevel());
		dto.setTotalScore(ts.getTotalScore());
		dto.setMarks(ts.getMarks());

		return dto;
	}

}
