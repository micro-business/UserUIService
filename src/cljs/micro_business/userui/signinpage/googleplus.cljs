(ns micro-business.userui.signinpage.googleplus
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(defui GooglePlusSignIn
  static om/IQuery
  (query [this]
         `[:caption :image-url])

  Object
  (render [this]
          (let [{:keys [caption image-url]} (om/props this)
                googlePlusButtonStyle #js {:className "uk-width-1-1 uk-button uk-button-large" :style #js {:background "#DE4C34" :color "#FFF"}}
                googlePlusImageStyle #js {:className "uk-float-left" :src image-url}
                googlePlusCaptionStyle #js {:className "uk-text"}]
            (apply dom/a
                   googlePlusButtonStyle
                   [(dom/img googlePlusImageStyle)
                    (dom/div googlePlusCaptionStyle  caption)]))))

(def googlePlusSignIn (om/factory GooglePlusSignIn))
