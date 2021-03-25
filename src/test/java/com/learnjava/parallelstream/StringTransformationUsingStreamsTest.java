package com.learnjava.parallelstream;

import com.learnjava.util.CommonUtil;
import jdk.jfr.Description;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class StringTransformationUsingStreamsTest {

    private StringTransformationUsingStreams stringTransformationUsingStreams = new StringTransformationUsingStreams();

    @Description("String should be expanded with its length and a hyphen at the beginning")
    @Test
    void testAddNameLengthTransform() {
        String testName = "George";
        String transformedName = stringTransformationUsingStreams.addNameLengthTransform(testName);
        assertAll("Should be expanded with its length and a hyphen at the beginning",
                () -> assertTrue(transformedName.contains("-")),
                () -> assertTrue(transformedName.contains(" ")),
                () -> assertTrue(StringUtils.startsWith(transformedName, String.valueOf(testName.length())))
        );
    }

    @Description("Should take not more than twice delay time for a number of entries (as executed in parallel)")
    @Test
    void testTransformStrings() {
        List<String> testList = List.of("George", "Alexander");
        Duration testDuration = Duration.of(StringTransformationUsingStreams.delayMilliSeconds * 2, ChronoUnit.MILLIS);
        assertTimeout(testDuration,
                () -> stringTransformationUsingStreams.transformStrings(testList, true),
                "Timeout exceeds twice delay timeout (provided two threads worked in parallel)"
        );
    }

    @Description("Should take not more than a defined delay time for a each of entries (as executed sequentially), and not more than twice delay time for a number of entries (as executed in parallel)")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testTransformStringsParametrized(boolean isParallel) {
        List<String> testList = List.of("George", "Alexander");
        Duration testDuration = Duration.of(StringTransformationUsingStreams.delayMilliSeconds * 2, ChronoUnit.MILLIS);

        CommonUtil.stopWatchReset();
        CommonUtil.startTimer();
        stringTransformationUsingStreams.transformStrings(testList, isParallel);
        CommonUtil.timeTaken();

        Duration actualDuration = Duration.ofMillis(CommonUtil.stopWatch.getTime());
        assertTrue(isParallel ? actualDuration.compareTo(testDuration) < 0 : actualDuration.compareTo(testDuration) > 0);
    }
}