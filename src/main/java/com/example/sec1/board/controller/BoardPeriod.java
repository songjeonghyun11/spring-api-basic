package com.example.sec1.board.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardPeriod {

    private LocalDate startDate;
    private LocalDate endDate;
}
