package androidx.core.content;

import android.content.ContentValues;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentValues.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContentValuesKt {
    @NotNull
    public static final ContentValues contentValuesOf(@NotNull v8.s<String, ? extends Object>... sVarArr) {
        ContentValues contentValues = new ContentValues(sVarArr.length);
        for (v8.s<String, ? extends Object> sVar : sVarArr) {
            String strA = sVar.a();
            Object objB = sVar.b();
            if (objB == null) {
                contentValues.putNull(strA);
            } else if (objB instanceof String) {
                contentValues.put(strA, (String) objB);
            } else if (objB instanceof Integer) {
                contentValues.put(strA, (Integer) objB);
            } else if (objB instanceof Long) {
                contentValues.put(strA, (Long) objB);
            } else if (objB instanceof Boolean) {
                contentValues.put(strA, (Boolean) objB);
            } else if (objB instanceof Float) {
                contentValues.put(strA, (Float) objB);
            } else if (objB instanceof Double) {
                contentValues.put(strA, (Double) objB);
            } else if (objB instanceof byte[]) {
                contentValues.put(strA, (byte[]) objB);
            } else if (objB instanceof Byte) {
                contentValues.put(strA, (Byte) objB);
            } else {
                if (!(objB instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + strA + '\"');
                }
                contentValues.put(strA, (Short) objB);
            }
        }
        return contentValues;
    }
}
