(ns signup-ui.core
    (:require [reagent.core :as reagent]))

;; -------------------------
;; Views

(defn home-page []
  [:div [:h2 "Hey"]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
