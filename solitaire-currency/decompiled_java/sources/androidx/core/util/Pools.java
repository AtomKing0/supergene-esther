package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Pools.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    /* JADX INFO: compiled from: Pools.kt */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NotNull T t10);
    }

    /* JADX INFO: compiled from: Pools.kt */
    public static class SimplePool<T> implements Pool<T> {

        @NotNull
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i10) {
            if (!(i10 > 0)) {
                throw new IllegalArgumentException("The max pool size must be > 0".toString());
            }
            this.pool = new Object[i10];
        }

        private final boolean isInPool(T t10) {
            int i10 = this.poolSize;
            for (int i11 = 0; i11 < i10; i11++) {
                if (this.pool[i11] == t10) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        @Nullable
        public T acquire() {
            int i10 = this.poolSize;
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            T t10 = (T) this.pool[i11];
            t.g(t10, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i11] = null;
            this.poolSize--;
            return t10;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NotNull T instance) {
            t.i(instance, "instance");
            if (!(!isInPool(instance))) {
                throw new IllegalStateException("Already in the pool!".toString());
            }
            int i10 = this.poolSize;
            Object[] objArr = this.pool;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = instance;
            this.poolSize = i10 + 1;
            return true;
        }
    }

    /* JADX INFO: compiled from: Pools.kt */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        @NotNull
        private final Object lock;

        public SynchronizedPool(int i10) {
            super(i10);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        @Nullable
        public T acquire() {
            T t10;
            synchronized (this.lock) {
                t10 = (T) super.acquire();
            }
            return t10;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NotNull T instance) {
            boolean zRelease;
            t.i(instance, "instance");
            synchronized (this.lock) {
                zRelease = super.release(instance);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
