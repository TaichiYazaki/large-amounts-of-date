package com.example.largeamountsofdate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import com.github.javafaker.Faker;

public class date {
  // カンマ
  private static final String COMMA = ",";
  // 改行
  private static final String NEW_LINE = "\n";

  public static void main(String[] args) {

    //ダミーデータのオブジェクトを生成
    Faker faker = new Faker(new Locale("ja_JP"));

    //CSVファイルへ書き込むためのオブジェクト
    FileWriter fileWriter = null;

    try {
      fileWriter = new FileWriter("person.csv");

      for (int i = 0; i < 10; i++) {
        //ランダムで名前の生成
        String firstName = faker.name().firstName();
        //ランダムで名字の生成
        String lastName = faker.name().lastName();
        //ランダムで郵便番号の生成
        String zipcode = faker.address().zipCode();
        //ランダムで住所の生成
        String address = String.join(faker.address().city(), faker.address().state());
        fileWriter.append(lastName);
        fileWriter.append(COMMA);
        fileWriter.append(firstName);
        fileWriter.append(COMMA);
        fileWriter.append(zipcode);
        fileWriter.append(COMMA);
        fileWriter.append(address);
        fileWriter.append(NEW_LINE);
      }
      System.out.println("CSVファイル出力完了");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      try {
        fileWriter.flush();
        fileWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
