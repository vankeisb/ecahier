// to be pasted in the wdevel script intepretor

import com.rvkb.ecahier.model.Entry

def store = woko.objectStore
def um = woko.userManager
def kakou = um.getUserByUsername('kakou')
def sofiane = um.getUserByUsername('sofiane')
def sandy = um.getUserByUsername('sandy')
def david = um.getUserByUsername('david')

def newEntry = { createdBy, participants, text ->
    store.save(new Entry([
      createdBy: createdBy,
      participants: participants,
      text: text
    ]))
}

newEntry kakou, [sofiane], """Sofiane a caillassé la voiture de Guillaume.
Résultat elle a l'air d'une poubelle ! Vraiment soso quel déconneur !
Du coup Kakou l'a marteau-pilonné sur le parking sans ménagement.
Faut pas le faire chier kakou."""

newEntry kakou, [sandy, david], """Sandy elle fait toujours chier la bite avec ses gérémiades.
David l'a menacée de l'envoyer au coin mais elle s'en tape manifestement ! Ces jeunes, ils
respectent plus rien ma parole..."""

