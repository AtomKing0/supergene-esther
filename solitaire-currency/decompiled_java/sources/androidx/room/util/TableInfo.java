package androidx.room.util;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.room.ColumnInfo;
import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;

/* JADX INFO: compiled from: TableInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final Map<String, Column> columns;

    @NotNull
    public final Set<ForeignKey> foreignKeys;

    @Nullable
    public final Set<Index> indices;

    @NotNull
    public final String name;

    /* JADX INFO: compiled from: TableInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TableInfo read(@NotNull SupportSQLiteDatabase database, @NotNull String tableName) {
            t.i(database, "database");
            t.i(tableName, "tableName");
            return TableInfoKt.readTableInfo(database, tableName);
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {

        @NotNull
        public final List<String> columnNames;

        @NotNull
        public final String onDelete;

        @NotNull
        public final String onUpdate;

        @NotNull
        public final List<String> referenceColumnNames;

        @NotNull
        public final String referenceTable;

        public ForeignKey(@NotNull String referenceTable, @NotNull String onDelete, @NotNull String onUpdate, @NotNull List<String> columnNames, @NotNull List<String> referenceColumnNames) {
            t.i(referenceTable, "referenceTable");
            t.i(onDelete, "onDelete");
            t.i(onUpdate, "onUpdate");
            t.i(columnNames, "columnNames");
            t.i(referenceColumnNames, "referenceColumnNames");
            this.referenceTable = referenceTable;
            this.onDelete = onDelete;
            this.onUpdate = onUpdate;
            this.columnNames = columnNames;
            this.referenceColumnNames = referenceColumnNames;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (t.d(this.referenceTable, foreignKey.referenceTable) && t.d(this.onDelete, foreignKey.onDelete) && t.d(this.onUpdate, foreignKey.onUpdate) && t.d(this.columnNames, foreignKey.columnNames)) {
                return t.d(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        @NotNull
        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {

        @NotNull
        private final String from;
        private final int id;
        private final int sequence;

        @NotNull
        private final String to;

        public ForeignKeyWithSequence(int i10, int i11, @NotNull String from, @NotNull String to) {
            t.i(from, "from");
            t.i(to, "to");
            this.id = i10;
            this.sequence = i11;
            this.from = from;
            this.to = to;
        }

        @NotNull
        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        @NotNull
        public final String getTo() {
            return this.to;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull ForeignKeyWithSequence other) {
            t.i(other, "other");
            int i10 = this.id - other.id;
            return i10 == 0 ? this.sequence - other.sequence : i10;
        }
    }

    public TableInfo(@NotNull String name, @NotNull Map<String, Column> columns, @NotNull Set<ForeignKey> foreignKeys, @Nullable Set<Index> set) {
        t.i(name, "name");
        t.i(columns, "columns");
        t.i(foreignKeys, "foreignKeys");
        this.name = name;
        this.columns = columns;
        this.foreignKeys = foreignKeys;
        this.indices = set;
    }

    @NotNull
    public static final TableInfo read(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@Nullable Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!t.d(this.name, tableInfo.name) || !t.d(this.columns, tableInfo.columns) || !t.d(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return t.d(set2, set);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.foreignKeys.hashCode();
    }

    @NotNull
    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i10, k kVar) {
        this(str, map, set, (i10 & 8) != 0 ? null : set2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(@NotNull String name, @NotNull Map<String, Column> columns, @NotNull Set<ForeignKey> foreignKeys) {
        this(name, columns, foreignKeys, z0.e());
        t.i(name, "name");
        t.i(columns, "columns");
        t.i(foreignKeys, "foreignKeys");
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    public static final class Column {

        @NotNull
        public static final Companion Companion = new Companion(null);
        public final int affinity;
        public final int createdFrom;

        @Nullable
        public final String defaultValue;

        @NotNull
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;

        @NotNull
        public final String type;

        /* JADX INFO: compiled from: TableInfo.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                while (i10 < str.length()) {
                    char cCharAt = str.charAt(i10);
                    int i13 = i12 + 1;
                    if (i12 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i11++;
                    } else if (cCharAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                        return false;
                    }
                    i10++;
                    i12 = i13;
                }
                return i11 == 0;
            }

            @SuppressLint({"SyntheticAccessor"})
            @VisibleForTesting
            public final boolean defaultValueEquals(@NotNull String current, @Nullable String str) {
                t.i(current, "current");
                if (t.d(current, str)) {
                    return true;
                }
                if (!containsSurroundingParenthesis(current)) {
                    return false;
                }
                String strSubstring = current.substring(1, current.length() - 1);
                t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return t.d(r.b1(strSubstring).toString(), str);
            }
        }

        public Column(@NotNull String name, @NotNull String type, boolean z10, int i10, @Nullable String str, int i11) {
            t.i(name, "name");
            t.i(type, "type");
            this.name = name;
            this.type = type;
            this.notNull = z10;
            this.primaryKeyPosition = i10;
            this.defaultValue = str;
            this.createdFrom = i11;
            this.affinity = findAffinity(type);
        }

        @SuppressLint({"SyntheticAccessor"})
        @VisibleForTesting
        public static final boolean defaultValueEquals(@NotNull String str, @Nullable String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String str) {
            if (str == null) {
                return 5;
            }
            Locale US = Locale.US;
            t.h(US, "US");
            String upperCase = str.toUpperCase(US);
            t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (r.P(upperCase, "INT", false, 2, null)) {
                return 3;
            }
            if (r.P(upperCase, "CHAR", false, 2, null) || r.P(upperCase, "CLOB", false, 2, null) || r.P(upperCase, "TEXT", false, 2, null)) {
                return 2;
            }
            if (r.P(upperCase, "BLOB", false, 2, null)) {
                return 5;
            }
            return (r.P(upperCase, "REAL", false, 2, null) || r.P(upperCase, "FLOA", false, 2, null) || r.P(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x0072, code lost:
        
            r1 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r7) {
            /*
                r6 = this;
                r0 = 1
                if (r6 != r7) goto L4
                return r0
            L4:
                boolean r1 = r7 instanceof androidx.room.util.TableInfo.Column
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                int r1 = r6.primaryKeyPosition
                r3 = r7
                androidx.room.util.TableInfo$Column r3 = (androidx.room.util.TableInfo.Column) r3
                int r3 = r3.primaryKeyPosition
                if (r1 == r3) goto L14
                return r2
            L14:
                java.lang.String r1 = r6.name
                androidx.room.util.TableInfo$Column r7 = (androidx.room.util.TableInfo.Column) r7
                java.lang.String r3 = r7.name
                boolean r1 = kotlin.jvm.internal.t.d(r1, r3)
                if (r1 != 0) goto L21
                return r2
            L21:
                boolean r1 = r6.notNull
                boolean r3 = r7.notNull
                if (r1 == r3) goto L28
                return r2
            L28:
                int r1 = r6.createdFrom
                r3 = 2
                if (r1 != r0) goto L40
                int r1 = r7.createdFrom
                if (r1 != r3) goto L40
                java.lang.String r1 = r6.defaultValue
                if (r1 == 0) goto L40
                androidx.room.util.TableInfo$Column$Companion r4 = androidx.room.util.TableInfo.Column.Companion
                java.lang.String r5 = r7.defaultValue
                boolean r1 = r4.defaultValueEquals(r1, r5)
                if (r1 != 0) goto L40
                return r2
            L40:
                int r1 = r6.createdFrom
                if (r1 != r3) goto L57
                int r1 = r7.createdFrom
                if (r1 != r0) goto L57
                java.lang.String r1 = r7.defaultValue
                if (r1 == 0) goto L57
                androidx.room.util.TableInfo$Column$Companion r3 = androidx.room.util.TableInfo.Column.Companion
                java.lang.String r4 = r6.defaultValue
                boolean r1 = r3.defaultValueEquals(r1, r4)
                if (r1 != 0) goto L57
                return r2
            L57:
                int r1 = r6.createdFrom
                if (r1 == 0) goto L78
                int r3 = r7.createdFrom
                if (r1 != r3) goto L78
                java.lang.String r1 = r6.defaultValue
                if (r1 == 0) goto L6e
                androidx.room.util.TableInfo$Column$Companion r3 = androidx.room.util.TableInfo.Column.Companion
                java.lang.String r4 = r7.defaultValue
                boolean r1 = r3.defaultValueEquals(r1, r4)
                if (r1 != 0) goto L74
                goto L72
            L6e:
                java.lang.String r1 = r7.defaultValue
                if (r1 == 0) goto L74
            L72:
                r1 = r0
                goto L75
            L74:
                r1 = r2
            L75:
                if (r1 == 0) goto L78
                return r2
            L78:
                int r1 = r6.affinity
                int r7 = r7.affinity
                if (r1 != r7) goto L7f
                goto L80
            L7f:
                r0 = r2
            L80:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Column.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Column(@NotNull String name, @NotNull String type, boolean z10, int i10) {
            this(name, type, z10, i10, null, 0);
            t.i(name, "name");
            t.i(type, "type");
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }
    }

    /* JADX INFO: compiled from: TableInfo.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        public static final String DEFAULT_PREFIX = "index_";

        @NotNull
        public final List<String> columns;

        @NotNull
        public final String name;

        @NotNull
        public List<String> orders;
        public final boolean unique;

        /* JADX INFO: compiled from: TableInfo.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public Index(@NotNull String name, boolean z10, @NotNull List<String> columns, @NotNull List<String> orders) {
            t.i(name, "name");
            t.i(columns, "columns");
            t.i(orders, "orders");
            this.name = name;
            this.unique = z10;
            this.columns = columns;
            this.orders = orders;
            List<String> arrayList = orders;
            if (arrayList.isEmpty()) {
                int size = columns.size();
                arrayList = new ArrayList(size);
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList.add(Index.Order.ASC.name());
                }
            }
            this.orders = (List) arrayList;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique == index.unique && t.d(this.columns, index.columns) && t.d(this.orders, index.orders)) {
                return q.K(this.name, DEFAULT_PREFIX, false, 2, null) ? q.K(index.name, DEFAULT_PREFIX, false, 2, null) : t.d(this.name, index.name);
            }
            return false;
        }

        public int hashCode() {
            return ((((((q.K(this.name, DEFAULT_PREFIX, false, 2, null) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        }

        @NotNull
        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        public Index(@NotNull String name, boolean z10, @NotNull List<String> columns) {
            t.i(name, "name");
            t.i(columns, "columns");
            int size = columns.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(Index.Order.ASC.name());
            }
            this(name, z10, columns, arrayList);
        }
    }
}
