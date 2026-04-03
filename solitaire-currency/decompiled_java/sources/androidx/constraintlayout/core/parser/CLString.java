package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLString extends CLElement {
    public CLString(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLString(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i10, int i11) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i10);
        sb.append("'");
        sb.append(content());
        sb.append("'");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        return "'" + content() + "'";
    }
}
