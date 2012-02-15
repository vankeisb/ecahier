package com.rvkb.ecahier.facets

import net.sourceforge.jfacets.annotations.FacetKey
import woko.facets.BaseResolutionFacet
import net.sourceforge.stripes.action.Resolution
import net.sourceforge.stripes.action.ActionBeanContext
import com.rvkb.ecahier.model.Entry
import net.sourceforge.stripes.action.RedirectResolution
import com.rvkb.ecahier.woko.EcahierUserManager
import net.sourceforge.stripes.action.SimpleMessage

@FacetKey(name="populate", profileId="all")
class Populate extends BaseResolutionFacet {

    Resolution getResolution(ActionBeanContext actionBeanContext) {


        def s = woko.objectStore
        def um = woko.userManager
        def kakou = um.getUserByUsername('kakou')
        def sofiane = um.getUserByUsername('sofiane')
        def sandy = um.getUserByUsername('sandy')
        def david = um.getUserByUsername('david')


        s.save(new Entry([
          createdBy: kakou,
          participants: [sofiane],
          text: """Sofiane a caillassé la voiture de Guillaume.
Résultat elle a l'air d'une poubelle ! Vraiment soso quel déconneur !
Du coup Kakou l'a marteau-pilonné sur le parking sans ménagement.
Faut pas le faire chier kakou."""]))

        s.save(new Entry([
          createdBy: kakou,
          participants: [sandy, david],
          text: """Sandy elle fait toujours chier la bite avec ses gérémiades.
David l'a menacée de l'envoyer au coin mais elle s'en tape manifestement ! Ces jeunes, ils
respectent plus rien ma parole..."""]))

        s.save(new Entry([
          createdBy: david,
          participants: [sofiane],
          text: """Soso apprend le hip hop dans la salle à manger. Au menu : <ul>
  <li>chant</li>
  <li>danse</li>
  <li>jurer comme un charretier</li>
  </ul>
  Bon, ok, le 3/ il savait <b>déjà</b> le faire !!
"""]))

        s.save(new Entry([
          createdBy: david,
          participants: [sandy],
          text: """Sandy a eu 18/20 au contrôle de musique. Au vu de ses résultats en math,
elle finira probablement <b>intermittent du spectacle</b>. Contacter le conservatoire
pour inscription !!!
"""]))


        actionBeanContext.messages.add(new SimpleMessage("Base remplie avec les données de test"))
        return new RedirectResolution("/home")
    }


}
