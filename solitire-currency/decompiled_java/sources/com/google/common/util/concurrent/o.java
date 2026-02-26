package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: ListeningExecutorService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface o extends ExecutorService {
    <T> m<T> submit(Callable<T> callable);
}
