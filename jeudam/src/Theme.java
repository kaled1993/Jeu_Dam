/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbissari
 */
public class Theme {
    private String imageCaseBlack;
    private String imageCaseWhite;
    private String imageCaseOption;
    private String imagePionBlack;
    private String imagePionWhite;
    private String imageQweenWhite;
    private String imageQweenBlack;
    private String imageQweenWhiteSel;
    private String imageQweenBlackSel;
    private String imagePionBlackSel;
    private String imagePionWhiteSel;
    private String imagePreview;

    public Theme() {
    }

    public Theme(String style) {
        this.imageCaseBlack = "/images/" + style + "/caseb.png";
        this.imageCaseWhite = "/images/" + style + "/casew.png";
        this.imageCaseOption = "/images/" + style + "/caseoption.png";
        this.imagePionBlack = "/images/" + style + "/pionb.png";
        this.imagePionWhite = "/images/" + style + "/pionw.png";
        this.imageQweenWhite = "/images/" + style + "/qweenw.png";
        this.imageQweenBlack = "/images/" + style + "/qweenb.png";
        this.imageQweenWhiteSel = "/images/" + style + "/qweenwsel.png";
        this.imageQweenBlackSel = "/images/" + style + "/qweenbsel.png";
        this.imagePionBlackSel = "/images/" + style + "/pionbsel.png";
        this.imagePionWhiteSel = "/images/" + style + "/pionwsel.png";
    }

    public String getImageCaseBlack() {
        return imageCaseBlack;
    }

    public String getImageCaseWhite() {
        return imageCaseWhite;
    }

    public String getImageCaseOption() {
        return imageCaseOption;
    }

    public String getImagePionBlack() {
        return imagePionBlack;
    }

    public String getImagePionWhite() {
        return imagePionWhite;
    }

    public String getImageQweenWhite() {
        return imageQweenWhite;
    }

    public String getImageQweenBlack() {
        return imageQweenBlack;
    }

    public String getImageQweenWhiteSel() {
        return imageQweenWhiteSel;
    }

    public String getImageQweenBlackSel() {
        return imageQweenBlackSel;
    }

    public String getImagePionBlackSel() {
        return imagePionBlackSel;
    }

    public String getImagePionWhiteSel() {
        return imagePionWhiteSel;
    }

    public String getImagePreview() {
        return imagePreview;
    }
    
}
