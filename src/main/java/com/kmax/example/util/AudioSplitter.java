package com.kmax.example.util;

import java.io.File;
import java.io.IOException;

/**
 * @author youping.tan
 * @date 2024/11/18 22:09
 */
public class AudioSplitter {

    /**
     * 切分音频
     *
     * @param inputFilePath 输入音频文件路径
     * @param outputDir     输出目录
     * @param segments      切分时间段（开始时间和结束时间）
     * @throws IOException 异常处理
     */
    public static void splitAudio(String inputFilePath, String outputDir, int[][] segments) throws IOException {
        // 确保输出目录存在
        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        for (int i = 0; i < segments.length; i++) {
            int startTime = segments[i][0]; // 开始时间（秒）
            int endTime = segments[i][1];   // 结束时间（秒）

            // 输出文件名
            String outputFilePath = String.format("%s\\segment_%d.aac", outputDir, i + 1);

            // 构造 FFmpeg 命令
            String command = String.format("ffmpeg -i %s -ss %d -to %d -c copy %s",
                    inputFilePath, startTime, endTime, outputFilePath);

            // 执行命令
            Process process = Runtime.getRuntime().exec(command);

            try {
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    throw new IOException("Error splitting audio: " + command);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Interrupted during audio splitting", e);
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\tanyouping\\Desktop\\audio1.aac"; // 输入音频文件
        String outputDir = "C:\\Users\\tanyouping\\Desktop\\output";   // 输出目录

        // 定义切分时间段，单位：秒
        int[][] segments = {
                {0, 10},    // 第一段：从0秒到30秒
                {11, 20},   // 第二段：从30秒到60秒
                {21, 25}    // 第三段：从60秒到90秒
        };

        try {
            splitAudio(inputFile, outputDir, segments);
            System.out.println("Audio split successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
