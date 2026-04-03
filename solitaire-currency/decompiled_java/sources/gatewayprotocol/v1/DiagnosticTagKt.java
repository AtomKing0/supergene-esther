package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DiagnosticTagKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticTagKt {

    @NotNull
    public static final DiagnosticTagKt INSTANCE = new DiagnosticTagKt();

    /* JADX INFO: compiled from: DiagnosticTagKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final DiagnosticEventRequestOuterClass.DiagnosticTag.Builder _builder;

        /* JADX INFO: compiled from: DiagnosticTagKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DiagnosticEventRequestOuterClass.DiagnosticTag.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: DiagnosticTagKt.kt */
        public static final class TagTypeProxy extends DslProxy {
            private TagTypeProxy() {
            }
        }

        public /* synthetic */ Dsl(DiagnosticEventRequestOuterClass.DiagnosticTag.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ DiagnosticEventRequestOuterClass.DiagnosticTag _build() {
            DiagnosticEventRequestOuterClass.DiagnosticTag diagnosticTagBuild = this._builder.build();
            t.h(diagnosticTagBuild, "_builder.build()");
            return diagnosticTagBuild;
        }

        public final /* synthetic */ void addAllTagType(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllTagType(values);
        }

        public final /* synthetic */ void addTagType(DslList dslList, DiagnosticEventRequestOuterClass.DiagnosticTagType value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addTagType(value);
        }

        public final void clearCustomTagType() {
            this._builder.clearCustomTagType();
        }

        public final void clearIntValue() {
            this._builder.clearIntValue();
        }

        public final void clearStringValue() {
            this._builder.clearStringValue();
        }

        public final /* synthetic */ void clearTagType(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearTagType();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @NotNull
        public final String getCustomTagType() {
            String customTagType = this._builder.getCustomTagType();
            t.h(customTagType, "_builder.getCustomTagType()");
            return customTagType;
        }

        public final int getIntValue() {
            return this._builder.getIntValue();
        }

        @NotNull
        public final String getStringValue() {
            String stringValue = this._builder.getStringValue();
            t.h(stringValue, "_builder.getStringValue()");
            return stringValue;
        }

        public final /* synthetic */ DslList getTagType() {
            List<DiagnosticEventRequestOuterClass.DiagnosticTagType> tagTypeList = this._builder.getTagTypeList();
            t.h(tagTypeList, "_builder.getTagTypeList()");
            return new DslList(tagTypeList);
        }

        @NotNull
        public final DiagnosticEventRequestOuterClass.DiagnosticTag.ValueCase getValueCase() {
            DiagnosticEventRequestOuterClass.DiagnosticTag.ValueCase valueCase = this._builder.getValueCase();
            t.h(valueCase, "_builder.getValueCase()");
            return valueCase;
        }

        public final boolean hasCustomTagType() {
            return this._builder.hasCustomTagType();
        }

        public final boolean hasIntValue() {
            return this._builder.hasIntValue();
        }

        public final boolean hasStringValue() {
            return this._builder.hasStringValue();
        }

        public final /* synthetic */ void plusAssignAllTagType(DslList<DiagnosticEventRequestOuterClass.DiagnosticTagType, TagTypeProxy> dslList, Iterable<? extends DiagnosticEventRequestOuterClass.DiagnosticTagType> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllTagType(dslList, values);
        }

        public final /* synthetic */ void plusAssignTagType(DslList<DiagnosticEventRequestOuterClass.DiagnosticTagType, TagTypeProxy> dslList, DiagnosticEventRequestOuterClass.DiagnosticTagType value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addTagType(dslList, value);
        }

        public final void setCustomTagType(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCustomTagType(value);
        }

        public final void setIntValue(int i10) {
            this._builder.setIntValue(i10);
        }

        public final void setStringValue(@NotNull String value) {
            t.i(value, "value");
            this._builder.setStringValue(value);
        }

        public final /* synthetic */ void setTagType(DslList dslList, int i10, DiagnosticEventRequestOuterClass.DiagnosticTagType value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setTagType(i10, value);
        }

        private Dsl(DiagnosticEventRequestOuterClass.DiagnosticTag.Builder builder) {
            this._builder = builder;
        }
    }

    private DiagnosticTagKt() {
    }
}
