package kotlin.reflect;

import v8.g;

/* JADX INFO: compiled from: KFunction.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KFunction<R> extends KCallable<R>, g<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();

    /* JADX INFO: compiled from: KFunction.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void isExternal$annotations() {
        }

        public static /* synthetic */ void isInfix$annotations() {
        }

        public static /* synthetic */ void isInline$annotations() {
        }

        public static /* synthetic */ void isOperator$annotations() {
        }

        public static /* synthetic */ void isSuspend$annotations() {
        }
    }
}
