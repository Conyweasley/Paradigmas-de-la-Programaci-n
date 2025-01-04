package namedEntity.dictionaries;

import java.util.ArrayList;
import java.util.Arrays;
/* Dataset of words for every named entity class */
public class Dictionaries { // Most common 25 words in English, modificadas para que no tengan espacios

/******** Jerarquia de clases de Entidad Nombrada ********/

    public static ArrayList<String> data_name = new ArrayList<>(
        Arrays.asList(
        "James", "John", "Robert", "Franko", "Michael", "William", "David", 
        "Mary", "Elizabeth", "Joseph", "Richard", "Charles", "Thomas", 
        "Christopher", "Daniel", "Patricia", "Matthew", "Jennifer", "Linda", 
        "Anthony", "Barbara", "Mark", "Susan", "Paul", "Steven", "Karen", 
        "Logan", "Donald", "Jamie", "Ana", "Ros", "Vladimir", "Carlo", 
        "Elon", "Meg")
    );

    public static ArrayList<String> data_surname = new ArrayList<>(
        Arrays.asList(
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", 
        "Garcia", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", 
        "Perez", "Taylor", "Anderson", "Wilson", "Jackson", "White", "Harris", 
        "Martin", "Thompson", "Moore", "Young", "Allen", "Biden", "Musk", 
        "Calloway", "Trump")
    );

    public static ArrayList<String> data_degree = new ArrayList<>(
        Arrays.asList(
        "Bachelor's", "Master's", "Doctorate", "Associate", "Bachelor", 
        "MBA", "JD", "Master", "PhD", "Arts", "Science", "Fine", "Degree", 
        "Engineering", "MD", "Public", "Health", "Education", "Social", 
        "Library", "Dental", "Surgery", "Medicine", "Philosophy")
    );

    public static ArrayList<String> data_country = new ArrayList<>(
        Arrays.asList(
        "Afghanistan", "Argentina", "Australia", "Brazil", "Canada", "China", 
        "Egypt", "France", "Germany", "India", "Indonesia", "Iran", "Italy", 
        "Japan", "Mexico", "Nigeria", "Pakistan", "Russia", "Country", 
        "Korea", "Spain", "Turkey", "UK", "USA", "Vietnam", "Taiwan", "U.S.",
        "Slovenia", "Russia")
    );

    public static ArrayList<String> data_city = new ArrayList<>(
        Arrays.asList(
        "Atlanta", "Bangkok", "Barcelona", "Beijing", "Berlin", "Chicago", 
        "Dubai", "Hong Kong", "Istanbul", "City", "London", "Angeles", 
        "Madrid", "Moscow", "Mumbai", "York", "Paris", "Janeiro", 
        "Rome", "Sao Paulo", "Seoul", "Shanghai", "Sydney", "Tokyo", "Miami",
        "Beijing", "Washington")
    );

    public static ArrayList<String> data_address = new ArrayList<>(
        Arrays.asList(
        "Street", "Avenue", "Road", "Lane", "Drive", "Court", "Circle", 
        "Boulevard", "Way", "Place", "Parkway", "Terrace", "Highway", 
        "Square", "Broadway", "Alley", "Path", "Crescent", "Gate", "Grove", 
        "Hill", "Loop", "Adress", "Manor", "View")
    );

    public static ArrayList<String> data_place_other = new ArrayList<>(
        Arrays.asList(
        "City", "Town", "Village", "Hamlet", "Municipality", "County", 
        "District", "Province", "State", "Territory", "Country", "Nation", 
        "Republic", "Empire", "Place", "Commonwealth", "Region", "Area", 
        "Zone", "Quarter", "Park", "Garden", "Square", "Boulevard", "Avenue", 
        "America")
    );
    
    public static ArrayList<String> data_company = new ArrayList<>(
        Arrays.asList(
        "Association", "Company", "Corporation", "Enterprise", "Foundation", 
        "Group", "Institute", "International", "Organization", "Partners", 
        "Service", "Solutions", "Systems", "Technologies", "Union", "United", 
        "Academy", "Alliance", "Center", "Council", "Federation", "Network", 
        "Society", "Business", "Ventures", "Apple", "Microsoft", "Amazon", 
        "Google", "Facebook", "Tesla", "Walmart", "Exxon", "AT&T", "Verizon",
        "Chevron", "Coca-Cola", "PepsiCo", "McDonald's", "Intel", "IBM", 
        "Cisco", "Oracle", "Netflix", "General Electric", "Nike", "TikTok",
        "F.B.I.", "CNN")
    );
    
    public static ArrayList<String> data_product = new ArrayList<>(
        Arrays.asList(
        "Shampoo", "Soap", "Lotion", "Perfume", "Toothpaste", "Mouthwash", 
        "Deodorant", "Product", "Razor", "Sunscreen", "Moisturizer", 
        "Cleanser", "Conditioner", "Max", "Pro", "Plus", "Nail polish", 
        "Lipstick", "Mascara", "Eyeliner", "Foundation", "Blush", 
        "Bronzer", "Premium", "Concealer")
    );

    public static ArrayList<String> data_event = new ArrayList<>(
        Arrays.asList(
        "Festival", "Concert", "Exhibition", "Conference", "Seminar", 
        "Webinar", "Symposium", "Workshop", "Charity", "Networking", 
        "Gala", "Fundraiser", "Convention", "Forum", "Summit", 
        "Marathon", "Parade", "Congress", "Showcase", "Expo", "Event",
        "Celebration", "Carnival", "Ceremony", "Anniversary")
    );

    public static ArrayList<String> data_date = new ArrayList<>(
        Arrays.asList(
        "January", "February", "March", "April", "May", "June", "July", 
        "August", "September", "October", "November", "December", "Monday", 
        "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", 
        "First", "Second", "Third", "Fourth", "Date", "Last", "Times", "2019",
        "2013", "2007.", "2011")
    );

/******** Jerarquia de clases de Tema ********/

    public static ArrayList<String> data_sport = new ArrayList<>(
        Arrays.asList(
        "Football", "Soccer", "Basketball", "Baseball", "Tennis", "Golf", 
        "Hockey", "Volleyball", "Rugby", "Cricket", "Swimming", "Cycling", 
        "Running", "Boxing", "Wrestling", "Weightlifting", "Gymnastics", 
        "Skiing", "Snowboarding", "Surfing", "Skateboarding", "Martial", 
        "Rowing", "Sailing", "Athletic")
    );

    public static ArrayList<String> data_culture = new ArrayList<>(
        Arrays.asList(
        "Art", "Music", "Literature", "Dance", "Theater", "Cinema", "Fashion",
        "Food", "Tradition", "Custom", "Festival", "Celebration", "Heritage", 
        "Folklore", "Religion", "Belief", "Mythology", "History", "Language", 
        "Customs", "Cuisine", "Design", "Sculpture", "Architecture", 
        "Photography")
    );

    public static ArrayList<String> data_politic = new ArrayList<>(
        Arrays.asList(
        "Democracy", "Election", "Government", "Policy", "Legislation", 
        "Campaign", "Candidate", "Voting", "Party", "Macri", "Politics", 
        "Kirchner", "Power", "Fernandez", "Administration", "Justice", 
        "Rights", "Law", "Corruption", "Bureaucracy", "Peron", 
        "Clinton", "Trump", "Biden", "Obama", "Opposition", "Nations")
    );

    public static ArrayList<String> data_football = new ArrayList<>(
        Arrays.asList(
        "Goal", "Corner", "Offside", "Penalty", "FIFA", "Maradona", "Mbappe", 
        "Referee", "Striker", "Midfielder", "Defender", "Goalkeeper", 
        "Haaland", "Dribble", "Pass", "Shot", "Header", "Substitution", 
        "Fixture", "League", "Cup", "Champions", "Messi", "Cristiano", "VAR")
    );

    public static ArrayList<String> data_basquetball = new ArrayList<>(
        Arrays.asList(
        "Basketball", "NBA", "Dunk", "Hoop", "Three-pointer", "Alley-oop",
        "Rebound", "Assist", "Block", "Foul", "Layup", "Dribble",
        "Shoot", "Hoop", "Free-throw", "Turnover", "Double-double",
        "Triple-double", "LeBron", "Jordan", "Kobe", "Curry", "Durant",
        "Basquet", "O'Neal")
    );

    public static ArrayList<String> data_tenis = new ArrayList<>(
        Arrays.asList(
        "Serve", "Forehand", "Backhand", "Volley", "Smash", "Ace", "Deuce",
        "Advantage", "Match", "Slam", "Wimbledon", "Garros", "Baseline",
        "Open", "Federer", "Nadal", "Djokovic", "Williams", "Nalbandian",
        "Murray", "Potro", "Schwartzman", "Net", "Slice", "Rally", "Tenis")
    );

    public static ArrayList<String> data_formula1 = new ArrayList<>(
        Arrays.asList(
        "Formula", "Race", "Driver", "Championship", "Car", "Team", "Circuit",
        "Lap", "Safety", "Pirelli", "Mercedes", "Bull", "Ferrari", "Hamilton", 
        "Verstappen", "Vettel", "Tyres", "Alonso", "Schumacher", "Lauda", 
        "Overtake", "Fangio", "Checo", "Podium", "Pole", "DRS", "Perez", 
        "Downforce", "Pitstop", "F1", "GP")
    );

    public static ArrayList<String> data_cinema = new ArrayList<>(
        Arrays.asList(
        "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", 
        "Documentary", "Drama", "Fantasy", "Horror", "Musical", "Mystery", 
        "Romance", "Fiction", "Short", "Sport", "Superhero", "Suspense", 
        "Thriller", "Tragedy", "Cinema", "Actor", "Actress", "Director", 
        "Oscar")
    );

    public static ArrayList<String> data_music = new ArrayList<>(
        Arrays.asList(
        "Rock", "Pop", "Jazz", "Blues", "Hip-hop", "Rap", "Funk", 
        "Soul", "Reggae", "Country", "Classical", "Electronic", "Disco",
        "Indie", "Metal", "Punk", "Madonna", "Folk", "Latin", "Beatles", 
        "Jackson", "Prince", "Spotify", "Music", "Album", "Song", "Band", 
        "Singer", "Guitar", "Drums", "Piano", "Bass", "Beatles")
    );

    public static ArrayList<String> data_pltcs_argentina = new ArrayList<>( 
        Arrays.asList(     
        "Presidente", "Presidenta", "Vicepresidente", "Vicepresidenta", 
        "Rosada", "Peronismo", "Radicalismo", "Kirchnerismo", "Macrismo", 
        "PJ", "UCR", "Cambiemos", "PRO", "Elecciones", "Senado", "Diputados", 
        "Kirchner", "Macri", "Fernandez", "Milei", "Massa", "Larreta", 
        "Kicillof", "Carrio", "Vidal", "Cristina", "Alberto", "Mauricio",
        "Evita", "Peron", "Nestor", "Radical", "Peronista", "Libertario",
        "Ministro", "Ministra", "Gobernador", "Gobernadora", "Jefe", "Jefa",
        "Candidato", "Candidata", "Candidatura", "Justicialismo", "Kirchnerista",
        "Macrista", "Progresismo", "Socialismo", "Comunismo", "Capitalismo")
        );

    public static ArrayList<String> data_pltcs_international = new ArrayList<>(
        Arrays.asList(
        "Democracy", "Dictatorship", "Superpower", "International law", 
        "United Nations", "Rights", "Diplomacy", "Globalization", "Mandela",
        "Sovereignty", "Security", "Peacekeeping", "Nationalism", "Treaty", 
        "Alliance", "Embassy", "Consulate", "Refugee", "Sanctions", "G7", 
        "G20", "Foreign aid", "Election", "Crisis", "Conflict", 
        "Multilateralism", "Merkel", "Putin", "Biden", "Trump", "Obama", 
        "Clinton", "Xi", "Macron", "Johnson", "Castro", "Chavez", "Maduro", 
        "Bolsonaro", "Fernandez", "Francis")
    );
}