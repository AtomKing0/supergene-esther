package p9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f32972a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final f f32973b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f32973b = new f("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private g() {
    }
}
