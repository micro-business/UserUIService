(ns micro-business.userui.signinpage.rootview
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]
   [micro-business.userui.signinpage.googleplus :as googleplus]))

(defui SignInPageRootView
  static om/IQuery
  (query [this]
         (let [googlePlusSignInSubQuery (om/get-query googleplus/GooglePlusSignIn)]
           `[:google-plus ~googlePlusSignInSubQuery]))

  Object
  (render [this]
          (let [{:keys [google-plus]} (om/props this)]
            (dom/div
             #js {:className "uk-vertical-align uk-text-center uk-height-1-1"}
             (dom/div
              #js {:className "uk-vertical-align-middle" :style #js {:width 280}}
              (dom/form
               #js {:className "uk-panel uk-panel-box uk-form"}
               (dom/div #js {:className "uk-form-row"}
                        (googleplus/googlePlusSignIn google-plus))))))))

(def signInPageRootView (om/factory SignInPageRootView))
