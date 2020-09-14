
package com.adidasAutomation.POJOS;

import com.google.gson.annotations.Expose;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;


public class Rain {

    @JsonProperty("1h")
    @Expose
    private Double lh;


    public Rain() {
    }


    public Rain(Double lh) {
        super();
        this.lh = lh;

    }

}
