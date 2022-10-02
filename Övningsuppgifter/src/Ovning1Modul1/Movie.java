package Ovning1Modul1;

public class Movie
{
    // ------- Instansvariabler ----------
    private String title;
    private int length;
    private String category;
    private String review;
    // ------- Konstruktorer ----------
    public Movie(String theTitle, int theLength, String theCategory, String 
    theReview)
    {
    title = theTitle;
    length = theLength;
    category = theCategory;
    review = theReview;
    }
    public Movie()
    {
    title = "Okänd titel";
    length = 0;
    category = "Okänd kategori";
    review = "Ingen recension gjord";
    }
    // Presentationsmetod
    public String toString()
    {
    String info = "Titel: " + title + "\nSpeltid: " + length + "\nKategori:" + category + "\nRecension: " + review;
    return info;
    }
    // ------- Set-metoder ----------
    public void setTitle(String newTitle)
    {
    title = newTitle;
    }
    public void setLength(int newLength)
    {
    length = newLength;
    }
    public void setCategory(String newCategory)
    {
    category = newCategory;
    }
    public void setReview(String newReview)
    {
    review = newReview;
    }
    // ------- Get-metoder ----------
    public String getTitle()
    {
    return title;
    }
    public int getLenght()
    {
    return length;
    }
    public String getCategory()
    {
    return category;
    }
    public String getReview()
    {
    return review;
    }
}
