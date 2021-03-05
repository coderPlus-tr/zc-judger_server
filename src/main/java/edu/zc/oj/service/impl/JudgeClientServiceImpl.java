package edu.zc.oj.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.zc.oj.entity.Config;
import edu.zc.oj.entity.Result;
import edu.zc.oj.service.JudgeClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author coderPlus-tr
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JudgeClientServiceImpl implements JudgeClientService {
    private ObjectMapper objectMapper;
    @Override
    public Result run(Config config) {
        Process process;
        Result result = null;
        String cmd = "libjudger.so " + config;
        try {
                process = Runtime.getRuntime().exec(cmd);
                InputStreamReader ir = new InputStreamReader(process.getInputStream());
                LineNumberReader input = new LineNumberReader(ir);
                String line;
                StringBuilder resultJson = new StringBuilder();
                while ((line = input.readLine()) != null) {
                    resultJson.append(line);
                }
                input.close();
                ir.close();
                result = objectMapper.readValue(resultJson.toString(), Result.class);

        } catch (IOException e) {
            log.warn(e.getMessage());
        }

        return result;
    }
}
