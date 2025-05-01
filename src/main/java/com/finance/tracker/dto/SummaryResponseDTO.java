package com.finance.tracker.dto;

import java.util.List;

public class SummaryResponseDTO {
    private List<TotalByCategoryDTO> totalByCategory;
    private Double totalGeneral;

    public SummaryResponseDTO(List<TotalByCategoryDTO> totalByCategory, Double totalGeneral) {
        this.totalByCategory = totalByCategory;
        this.totalGeneral = totalGeneral;
    }

    public List<TotalByCategoryDTO> getTotalByCategory() {
        return totalByCategory;
    }

    public void setTotalByCategory(List<TotalByCategoryDTO> totalByCategory) {
        this.totalByCategory = totalByCategory;
    }

    public Double getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(Double totalGeneral) {
        this.totalGeneral = totalGeneral;
    }
}
