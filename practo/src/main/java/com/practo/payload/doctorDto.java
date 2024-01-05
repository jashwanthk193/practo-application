package com.practo.payload;

import com.practo.Entity.Doctor;
import com.practo.Entity.review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class doctorDto {
    private Doctor doctor;
    private List<review> reviews;
    private double ratingPercentage;
}
