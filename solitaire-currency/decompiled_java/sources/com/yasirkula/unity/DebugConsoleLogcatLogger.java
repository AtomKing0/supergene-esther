package com.yasirkula.unity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes4.dex */
public class DebugConsoleLogcatLogger {
    private LogcatWorker worker;

    private static class LogcatWorker implements Runnable {
        private String command;
        private DebugConsoleLogcatLogReceiver logReceiver;
        private volatile boolean running = true;

        public LogcatWorker(DebugConsoleLogcatLogReceiver debugConsoleLogcatLogReceiver, String str) {
            this.logReceiver = debugConsoleLogcatLogReceiver;
            this.command = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runtime.getRuntime().exec("logcat -c");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(this.command).getInputStream()));
                while (this.running) {
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            this.logReceiver.OnLogReceived(line);
                        }
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        public void terminate() {
            this.running = false;
        }
    }

    public void Start(DebugConsoleLogcatLogReceiver debugConsoleLogcatLogReceiver, String str) {
        Stop();
        if (debugConsoleLogcatLogReceiver == null) {
            return;
        }
        String str2 = "logcat";
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() > 0) {
                str2 = "logcat " + strTrim;
            }
        }
        this.worker = new LogcatWorker(debugConsoleLogcatLogReceiver, str2);
        new Thread(this.worker).start();
    }

    public void Stop() {
        LogcatWorker logcatWorker = this.worker;
        if (logcatWorker != null) {
            logcatWorker.terminate();
            this.worker = null;
        }
    }
}
