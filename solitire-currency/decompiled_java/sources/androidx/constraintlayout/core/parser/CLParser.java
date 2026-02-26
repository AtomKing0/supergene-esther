package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLParser {
    static boolean DEBUG = false;
    private boolean hasComment = false;
    private int lineNumber;
    private String mContent;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = iArr;
            try {
                iArr[TYPE.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i10, TYPE type, boolean z10, char[] cArr) {
        CLElement cLElementAllocate;
        if (DEBUG) {
            System.out.println("CREATE " + type + " at " + cArr[i10]);
        }
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[type.ordinal()]) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i10++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i10++;
                break;
            case 3:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.lineNumber);
        if (z10) {
            cLElementAllocate.setStart(i10);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i10, char c10, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c10 == '\t' || c10 == '\n' || c10 == '\r' || c10 == ' ') {
            return cLElement;
        }
        if (c10 == '\"' || c10 == '\'') {
            return cLElement instanceof CLObject ? createElement(cLElement, i10, TYPE.KEY, true, cArr) : createElement(cLElement, i10, TYPE.STRING, true, cArr);
        }
        if (c10 == '[') {
            return createElement(cLElement, i10, TYPE.ARRAY, true, cArr);
        }
        if (c10 != ']') {
            if (c10 == '{') {
                return createElement(cLElement, i10, TYPE.OBJECT, true, cArr);
            }
            if (c10 != '}') {
                switch (c10) {
                    case '+':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return createElement(cLElement, i10, TYPE.NUMBER, true, cArr);
                    case ',':
                    case ':':
                        return cLElement;
                    case '/':
                        int i11 = i10 + 1;
                        if (i11 >= cArr.length || cArr[i11] != '/') {
                            return cLElement;
                        }
                        this.hasComment = true;
                        return cLElement;
                    default:
                        if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                            return createElement(cLElement, i10, TYPE.KEY, true, cArr);
                        }
                        CLElement cLElementCreateElement = createElement(cLElement, i10, TYPE.TOKEN, true, cArr);
                        CLToken cLToken = (CLToken) cLElementCreateElement;
                        if (cLToken.validate(c10, i10)) {
                            return cLElementCreateElement;
                        }
                        throw new CLParsingException("incorrect token <" + c10 + "> at line " + this.lineNumber, cLToken);
                }
            }
        }
        cLElement.setEnd(i10 - 1);
        CLElement container = cLElement.getContainer();
        container.setEnd(i10);
        return container;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLObject parse() throws CLParsingException {
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i10 = 1;
        this.lineNumber = 1;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            char c10 = charArray[i11];
            if (c10 == '{') {
                break;
            }
            if (c10 == '\n') {
                this.lineNumber++;
            }
            i11++;
        }
        if (i11 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.lineNumber);
        cLObjectAllocate.setStart(i11);
        int i12 = i11 + 1;
        CLElement container = cLObjectAllocate;
        while (i12 < length) {
            char c11 = charArray[i12];
            if (c11 == '\n') {
                this.lineNumber += i10;
            }
            if (this.hasComment) {
                if (c11 == '\n') {
                    this.hasComment = z10;
                } else {
                    continue;
                    i12++;
                    i10 = 1;
                    z10 = false;
                }
            }
            if (container == null) {
                break;
            }
            if (container.isDone()) {
                container = getNextJsonElement(i12, c11, container, charArray);
            } else if (container instanceof CLObject) {
                if (c11 == '}') {
                    container.setEnd(i12 - 1);
                } else {
                    container = getNextJsonElement(i12, c11, container, charArray);
                }
            } else if (!(container instanceof CLArray)) {
                boolean z11 = container instanceof CLString;
                if (z11) {
                    long j10 = container.start;
                    if (charArray[(int) j10] == c11) {
                        container.setStart(j10 + 1);
                        container.setEnd(i12 - 1);
                    }
                } else {
                    if (container instanceof CLToken) {
                        CLToken cLToken = (CLToken) container;
                        if (!cLToken.validate(c11, i12)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.lineNumber, cLToken);
                        }
                    }
                    if ((container instanceof CLKey) || z11) {
                        long j11 = container.start;
                        char c12 = charArray[(int) j11];
                        if ((c12 == '\'' || c12 == '\"') && c12 == c11) {
                            container.setStart(j11 + 1);
                            container.setEnd(i12 - 1);
                        }
                    }
                    if (!container.isDone() && (c11 == '}' || c11 == ']' || c11 == ',' || c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n' || c11 == ':')) {
                        long j12 = i12 - 1;
                        container.setEnd(j12);
                        if (c11 == '}' || c11 == ']') {
                            container = container.getContainer();
                            container.setEnd(j12);
                            if (container instanceof CLKey) {
                                container = container.getContainer();
                                container.setEnd(j12);
                            }
                        }
                    }
                }
            } else if (c11 == ']') {
                container.setEnd(i12 - 1);
            } else {
                container = getNextJsonElement(i12, c11, container, charArray);
            }
            if (container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                container = container.getContainer();
            }
            i12++;
            i10 = 1;
            z10 = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.start) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (DEBUG) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }
}
