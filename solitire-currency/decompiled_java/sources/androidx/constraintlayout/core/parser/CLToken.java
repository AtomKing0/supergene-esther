package androidx.constraintlayout.core.parser;

import com.ironsource.mediationsdk.metadata.a;

/* JADX INFO: loaded from: classes.dex */
public class CLToken extends CLElement {
    int index;
    char[] tokenFalse;
    char[] tokenNull;
    char[] tokenTrue;
    Type type;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLToken$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = iArr;
            try {
                iArr[Type.TRUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.index = 0;
        this.type = Type.UNKNOWN;
        this.tokenTrue = a.f13688g.toCharArray();
        this.tokenFalse = "false".toCharArray();
        this.tokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.type;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.type;
    }

    public boolean isNull() throws CLParsingException {
        if (this.type == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i10, int i11) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i10);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (!CLParser.DEBUG) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c10, long j10) {
        int i10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        if (i10 == 1) {
            char[] cArr = this.tokenTrue;
            int i11 = this.index;
            z = cArr[i11] == c10;
            if (z && i11 + 1 == cArr.length) {
                setEnd(j10);
            }
        } else if (i10 == 2) {
            char[] cArr2 = this.tokenFalse;
            int i12 = this.index;
            z = cArr2[i12] == c10;
            if (z && i12 + 1 == cArr2.length) {
                setEnd(j10);
            }
        } else if (i10 == 3) {
            char[] cArr3 = this.tokenNull;
            int i13 = this.index;
            z = cArr3[i13] == c10;
            if (z && i13 + 1 == cArr3.length) {
                setEnd(j10);
            }
        } else if (i10 == 4) {
            char[] cArr4 = this.tokenTrue;
            int i14 = this.index;
            if (cArr4[i14] == c10) {
                this.type = Type.TRUE;
            } else if (this.tokenFalse[i14] == c10) {
                this.type = Type.FALSE;
            } else if (this.tokenNull[i14] == c10) {
                this.type = Type.NULL;
            }
            z = true;
        }
        this.index++;
        return z;
    }
}
