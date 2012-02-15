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

newEntry kakou, [sofiane], """Sofiane a caillass� la voiture de Guillaume.
R�sultat elle a l'air d'une poubelle ! Vraiment soso quel d�conneur !
Du coup Kakou l'a marteau-pilonn� sur le parking sans m�nagement.
Faut pas le faire chier kakou."""

newEntry kakou, [sandy, david], """Sandy elle fait toujours chier la bite avec ses g�r�miades.
David l'a menac�e de l'envoyer au coin mais elle s'en tape manifestement ! Ces jeunes, ils
respectent plus rien ma parole..."""

