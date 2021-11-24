Math 1205-001 Project, Fall 2021 semester
Noah Bockmuehl

Mount Royal University
-----------------------------------
This project is a rough simulation of how an 80/20 principle generally forms.  It simulates a row of cells in a petri dish, each of which may pseudo-randomly be fed a sugar.  Upon being fed, the cell will grow. As each cell gets larger in diameter, it becomes more likely to receive the next sugar drop.

  *To any developers who stumble across this project, please note that I am an amateur developer. Please forgive the abysmal documentation and clunky spaghetti code. I may return to this project in the future to clean it up.*

-----------------------------------
HOW TO RUN
  The main user interface is in client.java. It runs the primary method in DemoScript.java which (hopefully) describes how a simulation runs. It should be able to run in any JDE using Java 11 (I think). 
  
  It runs using System.in as an input scanner, such that the user may define the number of cells and sugars to apply to a simulation.

-----------------------------------
REFERENCES/FURTHER READINGS

The “80/20 Rule” and Core Journals 
  Thomas E. Nisonger
  https://www.tandfonline.com/doi/full/10.1080/03615260801970774
  
Vilfredo Pareto : Beyond Disciplinary Boundaries, 
    edited by AlasdairJ. Marshall, and Joseph V. Femia, Taylor & Francis Group, 2012. 
    https://ebookcentral.proquest.com/lib/mtroyal-ebooks/detail.action?docID=823565.
  
Human Behavior and the Principle of Least Effort: An Introduction to Human Ecology
  George Kingsley Zipf
  https://books.google.ca/books?hl=en&lr=&id=m-XDCwAAQBAJ&oi=fnd&pg=PT4&ots=Dn-2tsbZ3u&sig=I-QlWcD6Yrhq7d7JpbfoeWg3DcA&redir_esc=y#v=onepage&q&f=false
  
Recommended viewing:
"The Zipf Mystery", Vsauce
  https://youtu.be/fCn8zs912OE

 