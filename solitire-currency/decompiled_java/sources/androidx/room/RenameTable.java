package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: RenameTable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@Repeatable(Entries.class)
@Retention(RetentionPolicy.CLASS)
public @interface RenameTable {

    /* JADX INFO: compiled from: RenameTable.kt */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface Entries {
        RenameTable[] value();
    }

    String fromTableName();

    String toTableName();
}
