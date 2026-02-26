package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SupportSQLiteQueryBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SupportSQLiteQueryBuilder {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    @Nullable
    private Object[] bindArgs;

    @Nullable
    private String[] columns;
    private boolean distinct;

    @Nullable
    private String groupBy;

    @Nullable
    private String having;

    @Nullable
    private String limit;

    @Nullable
    private String orderBy;

    @Nullable
    private String selection;

    @NotNull
    private final String table;

    /* JADX INFO: compiled from: SupportSQLiteQueryBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final SupportSQLiteQueryBuilder builder(@NotNull String tableName) {
            t.i(tableName, "tableName");
            return new SupportSQLiteQueryBuilder(tableName, null);
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, k kVar) {
        this(str);
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    @NotNull
    public static final SupportSQLiteQueryBuilder builder(@NotNull String str) {
        return Companion.builder(str);
    }

    @NotNull
    public final SupportSQLiteQueryBuilder columns(@Nullable String[] strArr) {
        this.columns = strArr;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.sqlite.db.SupportSQLiteQuery create() {
        /*
            r5 = this;
            java.lang.String r0 = r5.groupBy
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
            int r0 = r0.length()
            if (r0 != 0) goto Ld
            goto Lf
        Ld:
            r0 = r1
            goto L10
        Lf:
            r0 = r2
        L10:
            if (r0 == 0) goto L25
            java.lang.String r0 = r5.having
            if (r0 == 0) goto L1f
            int r0 = r0.length()
            if (r0 != 0) goto L1d
            goto L1f
        L1d:
            r0 = r1
            goto L20
        L1f:
            r0 = r2
        L20:
            if (r0 == 0) goto L23
            goto L25
        L23:
            r0 = r1
            goto L26
        L25:
            r0 = r2
        L26:
            if (r0 == 0) goto L96
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 120(0x78, float:1.68E-43)
            r0.<init>(r3)
            java.lang.String r3 = "SELECT "
            r0.append(r3)
            boolean r3 = r5.distinct
            if (r3 == 0) goto L3d
            java.lang.String r3 = "DISTINCT "
            r0.append(r3)
        L3d:
            java.lang.String[] r3 = r5.columns
            if (r3 == 0) goto L49
            int r4 = r3.length
            if (r4 != 0) goto L46
            r4 = r2
            goto L47
        L46:
            r4 = r1
        L47:
            if (r4 == 0) goto L4a
        L49:
            r1 = r2
        L4a:
            if (r1 != 0) goto L53
            kotlin.jvm.internal.t.f(r3)
            r5.appendColumns(r0, r3)
            goto L58
        L53:
            java.lang.String r1 = "* "
            r0.append(r1)
        L58:
            java.lang.String r1 = "FROM "
            r0.append(r1)
            java.lang.String r1 = r5.table
            r0.append(r1)
            java.lang.String r1 = " WHERE "
            java.lang.String r2 = r5.selection
            r5.appendClause(r0, r1, r2)
            java.lang.String r1 = " GROUP BY "
            java.lang.String r2 = r5.groupBy
            r5.appendClause(r0, r1, r2)
            java.lang.String r1 = " HAVING "
            java.lang.String r2 = r5.having
            r5.appendClause(r0, r1, r2)
            java.lang.String r1 = " ORDER BY "
            java.lang.String r2 = r5.orderBy
            r5.appendClause(r0, r1, r2)
            java.lang.String r1 = " LIMIT "
            java.lang.String r2 = r5.limit
            r5.appendClause(r0, r1, r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "StringBuilder(capacity).…builderAction).toString()"
            kotlin.jvm.internal.t.h(r0, r1)
            androidx.sqlite.db.SimpleSQLiteQuery r1 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.Object[] r2 = r5.bindArgs
            r1.<init>(r0, r2)
            return r1
        L96:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "HAVING clauses are only permitted when using a groupBy clause"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteQueryBuilder.create():androidx.sqlite.db.SupportSQLiteQuery");
    }

    @NotNull
    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder groupBy(@Nullable String str) {
        this.groupBy = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder having(@Nullable String str) {
        this.having = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder limit(@NotNull String limit) {
        t.i(limit, "limit");
        boolean zMatches = limitPattern.matcher(limit).matches();
        boolean z10 = true;
        if (!(limit.length() == 0) && !zMatches) {
            z10 = false;
        }
        if (z10) {
            this.limit = limit;
            return this;
        }
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + limit).toString());
    }

    @NotNull
    public final SupportSQLiteQueryBuilder orderBy(@Nullable String str) {
        this.orderBy = str;
        return this;
    }

    @NotNull
    public final SupportSQLiteQueryBuilder selection(@Nullable String str, @Nullable Object[] objArr) {
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }
}
