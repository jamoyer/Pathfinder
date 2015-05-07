package pathfinder.metaObjects;

import java.util.Arrays;
import java.util.Comparator;

public class EnumUtil
{
    private static class EnumNameComparator implements Comparator<Enum<?>>
    {

        public static final Comparator<Enum<?>> INSTANCE = new EnumNameComparator();

        @Override
        public int compare(Enum<?> enum1, Enum<?> enum2)
        {
            return enum1.name().compareTo(enum2.name());
        }

    }

    /**
     * Sorts the array of Enums by their name alphabetically. Does not alter the given parameter.
     *
     * @param arr
     * @return A new array of the sorted Enum elements.
     */
    public static Enum<?>[] sortAlphabetically(final Enum<?>[] arr)
    {
        final Enum<?>[] toReturn = Arrays.copyOf(arr, arr.length);
        Arrays.sort(toReturn, EnumNameComparator.INSTANCE);
        return toReturn;
    }
}
