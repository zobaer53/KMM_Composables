//
//  ComposeView.swift
//  iosApp
//
//  Created by Ankit Kumar on 30/07/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared
struct ComposeView:UIViewControllerRepresentable{
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {

    }
    func makeUIViewController(context: Context) -> some UIViewController {
        Main_iosKt.MainViewController()

    }
}
