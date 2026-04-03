package androidx.compose.ui.autofill;

import androidx.autofill.HintConstants;
import androidx.compose.ui.ExperimentalComposeUiApi;
import java.util.HashMap;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.y;

/* JADX INFO: compiled from: AndroidAutofillType.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutofillType_androidKt {

    @NotNull
    private static final HashMap<AutofillType, String> androidAutofillTypes = r0.i(y.a(AutofillType.EmailAddress, HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS), y.a(AutofillType.Username, "username"), y.a(AutofillType.Password, HintConstants.AUTOFILL_HINT_PASSWORD), y.a(AutofillType.NewUsername, HintConstants.AUTOFILL_HINT_NEW_USERNAME), y.a(AutofillType.NewPassword, HintConstants.AUTOFILL_HINT_NEW_PASSWORD), y.a(AutofillType.PostalAddress, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS), y.a(AutofillType.PostalCode, HintConstants.AUTOFILL_HINT_POSTAL_CODE), y.a(AutofillType.CreditCardNumber, HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER), y.a(AutofillType.CreditCardSecurityCode, HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE), y.a(AutofillType.CreditCardExpirationDate, HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE), y.a(AutofillType.CreditCardExpirationMonth, HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH), y.a(AutofillType.CreditCardExpirationYear, HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR), y.a(AutofillType.CreditCardExpirationDay, HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY), y.a(AutofillType.AddressCountry, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY), y.a(AutofillType.AddressRegion, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION), y.a(AutofillType.AddressLocality, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY), y.a(AutofillType.AddressStreet, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS), y.a(AutofillType.AddressAuxiliaryDetails, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS), y.a(AutofillType.PostalCodeExtended, HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE), y.a(AutofillType.PersonFullName, HintConstants.AUTOFILL_HINT_PERSON_NAME), y.a(AutofillType.PersonFirstName, HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN), y.a(AutofillType.PersonLastName, HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY), y.a(AutofillType.PersonMiddleName, HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE), y.a(AutofillType.PersonMiddleInitial, HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL), y.a(AutofillType.PersonNamePrefix, HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX), y.a(AutofillType.PersonNameSuffix, HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX), y.a(AutofillType.PhoneNumber, HintConstants.AUTOFILL_HINT_PHONE_NUMBER), y.a(AutofillType.PhoneNumberDevice, HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE), y.a(AutofillType.PhoneCountryCode, HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE), y.a(AutofillType.PhoneNumberNational, HintConstants.AUTOFILL_HINT_PHONE_NATIONAL), y.a(AutofillType.Gender, HintConstants.AUTOFILL_HINT_GENDER), y.a(AutofillType.BirthDateFull, HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL), y.a(AutofillType.BirthDateDay, HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY), y.a(AutofillType.BirthDateMonth, HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH), y.a(AutofillType.BirthDateYear, HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR), y.a(AutofillType.SmsOtpCode, HintConstants.AUTOFILL_HINT_SMS_OTP));

    @NotNull
    public static final String getAndroidType(@NotNull AutofillType autofillType) {
        t.i(autofillType, "<this>");
        String str = androidAutofillTypes.get(autofillType);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unsupported autofill type".toString());
    }

    @ExperimentalComposeUiApi
    private static /* synthetic */ void getAndroidAutofillTypes$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getAndroidType$annotations(AutofillType autofillType) {
    }
}
