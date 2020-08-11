package Exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exam3 {

  public static void main(String[] args) {
    try {
      new Exam3().pickUp("input.txt", "output.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 動詞の次に助動詞が続くパターンを抽出して, 動詞+助動詞 を出力します.
   *
   * @param inputPath  入力の形態素解析結果のファイルパス
   * @param outputPath 出力ファイルパス
   */
  public void pickUp(String inputPath, String outputPath) throws Exception {

    // 入力データ
    BufferedReader br = new BufferedReader(new FileReader(inputPath));
    List<String> inputData = br.lines().collect(Collectors.toList());
    br.close();

    // 出力データ格納先
    List<String> outputData = new ArrayList<>();
    for (int i = 0; i < inputData.size() - 1; i++) {
      String line = inputData.get(i);
      if (!line.equals("EOS")) {
        String[] morpheme = line.split("[\t,]");

        //// 表層形を取得
        //String surface = morpheme[0];
        // 品詞名を取得
        String partOfSpeech = morpheme[1];

        if (partOfSpeech.equals("動詞")) {
          // 動詞の場合は次の形態素の品詞をチェック
          String[] nextMorpheme = inputData.get(i + 1).split("[\t,]");
          //String nextSurface = nextMorpheme[0];
          String nextPartOfSpeech = nextMorpheme[1];

          if (nextPartOfSpeech.equals("助動詞")) {
        	// 表層形を取得
            String surface = morpheme[0];
        	String nextSurface = nextMorpheme[0];
            // 動詞の次が助動詞なら結果リストに追加する
            outputData.add(surface + nextSurface);
            i++;
          }
        }
      }
    }

    // 結果出力
    BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
    for (String line : outputData) {
      bw.write(line);
      bw.newLine();
    }
    bw.close();
  }
}