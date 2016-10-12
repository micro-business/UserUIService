(ns signup-ui.core
    (:require [reagent.core :as reagent]))

;; -------------------------
;; Views

(defn user-details []
  [:div.uk-margin-large-bottom
   [:div.uk-form-row [:h3.uk-float-left.uk-margin-bottom-remove "User Details"]]
   [:div.uk-form-row
    [:input.uk-width-1-2.uk-form-large {:type "text" :placeholder "Email"}]
    [:input.uk-width-1-2.uk-form-large {:type "text" :placeholder "Username (Optional)"}]]
  [:div.uk-form-row
   [:input.uk-width-1-2.uk-form-large {:type "text" :placeholder "Password"}]
   [:input.uk-width-1-2.uk-form-large {:type "text" :placeholder "Password Confirmation"}]]])


(defn address-details [region]
  [:div.uk-margin-large-bottom
   [:div.uk-form-row [:h3.uk-float-left "Address Details"]]
   [:div.uk-form-row
    [:input.uk-width-1-1 {:type "text" :placeholder "Address Line 1"}]]
   [:div.uk-form-row
    [:input.uk-width-1-1 {:type "text" :placeholder "Address Line 2"}]]
   (if (= region "unknown") [:div.uk-form-row
                             [:input.uk-width-1-1 {:type "text" :placeholder "Address Line 3"}]])
   [:div.uk-form-row
    [:input.uk-width-1-3 {:type "text" :placeholder "Suburb"}]
    [:input.uk-width-1-3 {:type "text" :placeholder "City"}]
    [:input.uk-width-1-3 {:type "text" :placeholder "Postcode"}]]
   [:div.uk-form-row
    [:input.uk-width-1-1 {:type "text" :placeholder "Country"}]]])

(defn home-page []
  [:div.uk-container.uk-container-center.uk-margin-top
   [:form.uk-panel.uk-panel-box.uk-form.uk-text-center
    [:h2.uk-margin-large-bottom "Registration Demo"]
    [user-details]
    [address-details "NZ"]
    [:div.uk-form-row
     [:p.uk-float-left "By clicking \"Register\", you agree to the Terms and Condition"]]
    [:div.uk-form-row [:a.uk-width-1-3.uk-float-right.uk-button.uk-button-primary.uk-button-large {:href "#"} "Register"]]]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
