package com.kigen.notes.ui.util;

/**
 * Author: kigen
 * Date: 25/09/2017.
 */

public class Util {

  public static  String shortenText(String text, int len){
    if(text.length()<len){
      return text;
    }else{
      return text.substring(0,(len-1)).concat("...");

    }

  }
}
