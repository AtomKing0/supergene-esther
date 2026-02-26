package androidx.media3.common.util;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface TimestampIterator {
    TimestampIterator copyOf();

    boolean hasNext();

    long next();
}
