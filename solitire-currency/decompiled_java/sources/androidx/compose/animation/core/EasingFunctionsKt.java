package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EasingFunctions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EasingFunctionsKt {

    @NotNull
    private static final Easing Ease = new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);

    @NotNull
    private static final Easing EaseOut = new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);

    @NotNull
    private static final Easing EaseIn = new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);

    @NotNull
    private static final Easing EaseInOut = new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);

    @NotNull
    private static final Easing EaseInSine = new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);

    @NotNull
    private static final Easing EaseOutSine = new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);

    @NotNull
    private static final Easing EaseInOutSine = new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);

    @NotNull
    private static final Easing EaseInCubic = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);

    @NotNull
    private static final Easing EaseOutCubic = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);

    @NotNull
    private static final Easing EaseInOutCubic = new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);

    @NotNull
    private static final Easing EaseInQuint = new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuint = new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuint = new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);

    @NotNull
    private static final Easing EaseInCirc = new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);

    @NotNull
    private static final Easing EaseOutCirc = new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);

    @NotNull
    private static final Easing EaseInOutCirc = new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);

    @NotNull
    private static final Easing EaseInQuad = new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuad = new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuad = new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);

    @NotNull
    private static final Easing EaseInQuart = new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuart = new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuart = new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);

    @NotNull
    private static final Easing EaseInExpo = new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);

    @NotNull
    private static final Easing EaseOutExpo = new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);

    @NotNull
    private static final Easing EaseInOutExpo = new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);

    @NotNull
    private static final Easing EaseInBack = new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);

    @NotNull
    private static final Easing EaseOutBack = new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);

    @NotNull
    private static final Easing EaseInOutBack = new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);

    @NotNull
    private static final Easing EaseInElastic = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInElastic$1
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            if (f10 == 1.0f) {
                return 1.0f;
            }
            return (float) (((double) (-((float) Math.pow(2.0f, r7 - 10.0f)))) * Math.sin(((double) ((f10 * 10.0f) - 10.75f)) * 2.0943951023931953d));
        }
    };

    @NotNull
    private static final Easing EaseOutElastic = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseOutElastic$1
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            if (f10 == 1.0f) {
                return 1.0f;
            }
            return (float) ((((double) ((float) Math.pow(2.0f, (-10.0f) * f10))) * Math.sin(((double) ((f10 * 10.0f) - 0.75f)) * 2.0943951023931953d)) + ((double) 1.0f));
        }
    };

    @NotNull
    private static final Easing EaseInOutElastic = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInOutElastic$1
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f10) {
            if (f10 == 0.0f) {
                return 0.0f;
            }
            if (f10 == 1.0f) {
                return 1.0f;
            }
            if (!(0.0f <= f10 && f10 <= 0.5f)) {
                double d10 = 2.0f;
                return ((float) ((((double) ((float) Math.pow(d10, ((-20.0f) * f10) + 10.0f))) * Math.sin(((double) ((f10 * 20.0f) - 11.125f)) * 1.3962634015954636d)) / d10)) + 1.0f;
            }
            double d11 = 2.0f;
            return (float) ((-(((double) ((float) Math.pow(d11, r11 - 10.0f))) * Math.sin(((double) ((f10 * 20.0f) - 11.125f)) * 1.3962634015954636d))) / d11);
        }
    };

    @NotNull
    private static final Easing EaseOutBounce = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseOutBounce$1
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f10) {
            float f11;
            float f12;
            if (f10 < 0.36363637f) {
                return 7.5625f * f10 * f10;
            }
            if (f10 < 0.72727275f) {
                float f13 = f10 - 0.54545456f;
                f11 = 7.5625f * f13 * f13;
                f12 = 0.75f;
            } else if (f10 < 0.90909094f) {
                float f14 = f10 - 0.8181818f;
                f11 = 7.5625f * f14 * f14;
                f12 = 0.9375f;
            } else {
                float f15 = f10 - 0.95454544f;
                f11 = 7.5625f * f15 * f15;
                f12 = 0.984375f;
            }
            return f11 + f12;
        }
    };

    @NotNull
    private static final Easing EaseInBounce = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInBounce$1
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f10) {
            return 1 - EasingFunctionsKt.getEaseOutBounce().transform(1.0f - f10);
        }
    };

    @NotNull
    private static final Easing EaseInOutBounce = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInOutBounce$1
        @Override // androidx.compose.animation.core.Easing
        public final float transform(float f10) {
            return (((double) f10) < 0.5d ? 1 - EasingFunctionsKt.getEaseOutBounce().transform(1.0f - (f10 * 2.0f)) : 1 + EasingFunctionsKt.getEaseOutBounce().transform((f10 * 2.0f) - 1.0f)) / 2.0f;
        }
    };

    @NotNull
    public static final Easing getEase() {
        return Ease;
    }

    @NotNull
    public static final Easing getEaseIn() {
        return EaseIn;
    }

    @NotNull
    public static final Easing getEaseInBack() {
        return EaseInBack;
    }

    @NotNull
    public static final Easing getEaseInBounce() {
        return EaseInBounce;
    }

    @NotNull
    public static final Easing getEaseInCirc() {
        return EaseInCirc;
    }

    @NotNull
    public static final Easing getEaseInCubic() {
        return EaseInCubic;
    }

    @NotNull
    public static final Easing getEaseInElastic() {
        return EaseInElastic;
    }

    @NotNull
    public static final Easing getEaseInExpo() {
        return EaseInExpo;
    }

    @NotNull
    public static final Easing getEaseInOut() {
        return EaseInOut;
    }

    @NotNull
    public static final Easing getEaseInOutBack() {
        return EaseInOutBack;
    }

    @NotNull
    public static final Easing getEaseInOutBounce() {
        return EaseInOutBounce;
    }

    @NotNull
    public static final Easing getEaseInOutCirc() {
        return EaseInOutCirc;
    }

    @NotNull
    public static final Easing getEaseInOutCubic() {
        return EaseInOutCubic;
    }

    @NotNull
    public static final Easing getEaseInOutElastic() {
        return EaseInOutElastic;
    }

    @NotNull
    public static final Easing getEaseInOutExpo() {
        return EaseInOutExpo;
    }

    @NotNull
    public static final Easing getEaseInOutQuad() {
        return EaseInOutQuad;
    }

    @NotNull
    public static final Easing getEaseInOutQuart() {
        return EaseInOutQuart;
    }

    @NotNull
    public static final Easing getEaseInOutQuint() {
        return EaseInOutQuint;
    }

    @NotNull
    public static final Easing getEaseInOutSine() {
        return EaseInOutSine;
    }

    @NotNull
    public static final Easing getEaseInQuad() {
        return EaseInQuad;
    }

    @NotNull
    public static final Easing getEaseInQuart() {
        return EaseInQuart;
    }

    @NotNull
    public static final Easing getEaseInQuint() {
        return EaseInQuint;
    }

    @NotNull
    public static final Easing getEaseInSine() {
        return EaseInSine;
    }

    @NotNull
    public static final Easing getEaseOut() {
        return EaseOut;
    }

    @NotNull
    public static final Easing getEaseOutBack() {
        return EaseOutBack;
    }

    @NotNull
    public static final Easing getEaseOutBounce() {
        return EaseOutBounce;
    }

    @NotNull
    public static final Easing getEaseOutCirc() {
        return EaseOutCirc;
    }

    @NotNull
    public static final Easing getEaseOutCubic() {
        return EaseOutCubic;
    }

    @NotNull
    public static final Easing getEaseOutElastic() {
        return EaseOutElastic;
    }

    @NotNull
    public static final Easing getEaseOutExpo() {
        return EaseOutExpo;
    }

    @NotNull
    public static final Easing getEaseOutQuad() {
        return EaseOutQuad;
    }

    @NotNull
    public static final Easing getEaseOutQuart() {
        return EaseOutQuart;
    }

    @NotNull
    public static final Easing getEaseOutQuint() {
        return EaseOutQuint;
    }

    @NotNull
    public static final Easing getEaseOutSine() {
        return EaseOutSine;
    }
}
