package feed;

import namedEntity.NamedEntity;
import namedEntity.heuristic.Heuristic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Modela el contenido de un articulo (ie, un item en el caso del rss feed) */

public class Article implements Serializable {
    private String title;
    private String text;
    private Date publicationDate;
    private String link;

    private final List<NamedEntity> namedEntityList = new ArrayList<NamedEntity>();

    public Article(String title, String text, Date publicationDate, String link) {
        super();
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
        this.link = link;
    }

    public static void main(String[] args) {
        Article a = new Article("This Historically Black University Created Its Own Tech Intern Pipeline",
                "A new program at Bowie State connects computing students directly with companies, bypassing an often harsh Silicon Valley vetting process",
                new Date(),
                "https://www.nytimes.com/2023/04/05/technology/bowie-hbcu-tech-intern-pipeline.html"
        );

        a.prettyPrint();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Article [title=" + title + ", text=" + text +
                ", publicationDate=" + publicationDate +
                ", link=" + link + "]";
    }

	public NamedEntity getNamedEntity(String namedEntity) {
    int index = namedEntityList.indexOf(new NamedEntity(namedEntity, new ArrayList<>(), 0));
    if (index >= 0) {
        return namedEntityList.get(index);
        }
    return null;
    }

    public int getWordCount() {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public void computeNamedEntities(Heuristic h) {
        String text = this.getTitle() + " " + this.getText();

		String charsToRemove = ".,;:()'!?\n";
        text = text.replaceAll("[" + charsToRemove + "]", "");

        for (String s : text.split(" ")) {
            if (h.isEntity(s)) {
                NamedEntity ne = this.getNamedEntity(s);
                if (ne == null) {
                    this.namedEntityList.add(new NamedEntity(s, null, 1));
                } else {
                    ne.incFrequency();
                }
            }
        }
    }

    public void prettyPrint() {
        System.out.println("**********************************************************************************************");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Publication Date: " + this.getPublicationDate());
        System.out.println("Link: " + this.getLink());
        System.out.println("Text: " + this.getText());
        System.out.println("**********************************************************************************************");

    }
}