package pathfinder.realWorldObject.creature;

import java.util.List;

/**
 * A list of the most common creature descriptions with the ability to add more
 * descriptors.
 * 
 * @author jacob
 *
 */
public class CreatureDescription
{
    private String name;
    private String eyeColor;
    private String skinColor;
    private String hairColor;
    private String gender;
    private int age;
    private String height;
    private String weight;
    private String homeland;
    private String deity;
    private String alignment;
    private String backStory;
    private List<String> additionalDescriptons;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEyeColor()
    {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    public String getSkinColor()
    {
        return skinColor;
    }

    public void setSkinColor(String skinColor)
    {
        this.skinColor = skinColor;
    }

    public String getHairColor()
    {
        return hairColor;
    }

    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getHomeland()
    {
        return homeland;
    }

    public void setHomeland(String homeland)
    {
        this.homeland = homeland;
    }

    public String getDeity()
    {
        return deity;
    }

    public void setDeity(String deity)
    {
        this.deity = deity;
    }

    public String getAlignment()
    {
        return alignment;
    }

    public void setAlignment(String alignment)
    {
        this.alignment = alignment;
    }

    public String getBackStory()
    {
        return backStory;
    }

    public void setBackStory(String backStory)
    {
        this.backStory = backStory;
    }

    public List<String> getAdditionalDescriptons()
    {
        return additionalDescriptons;
    }

    public void setAdditionalDescriptons(List<String> additionalDescriptons)
    {
        this.additionalDescriptons = additionalDescriptons;
    }
}
