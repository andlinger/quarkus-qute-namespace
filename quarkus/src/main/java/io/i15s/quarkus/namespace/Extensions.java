package io.i15s.quarkus.namespace;

import io.quarkus.qute.TemplateExtension;
import io.quarkus.qute.i18n.MessageBundles;

import java.util.Locale;

@TemplateExtension(namespace = "base")
public class Extensions {

    static String formatCountry(String countryCode, @TemplateExtension.TemplateAttribute(MessageBundles.ATTRIBUTE_LOCALE) Object locale) {
        return new Locale("", countryCode)
                .getDisplayCountry((Locale) locale);
    }

    static String formatCountryEnglish(String countryCode) {
        return new Locale("", countryCode)
                .getDisplayCountry(Locale.ENGLISH);
    }
}
