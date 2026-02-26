package s5;

/* JADX INFO: compiled from: Protobuf.java */
/* JADX INFO: loaded from: classes3.dex */
public @interface d {

    /* JADX INFO: compiled from: Protobuf.java */
    public enum a {
        DEFAULT,
        SIGNED,
        FIXED
    }

    a intEncoding() default a.DEFAULT;

    int tag();
}
