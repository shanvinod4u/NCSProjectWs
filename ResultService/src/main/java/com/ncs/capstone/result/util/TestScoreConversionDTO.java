package com.ncs.capstone.result.util;

import com.ncs.capstone.result.dto.TestScoreResponseDTO;
import com.ncs.capstone.result.model.TestScore;

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
